package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ProductController {
    private final IProductService productService;

    @Autowired
    ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("new-product")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "create-product";
    }

    @PostMapping("add-product")
    public String addNewProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/new-product";
    }

    @GetMapping("shop")
    public String showShop(Model model, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            session.setAttribute("cart", new Cart());
        }
        model.addAttribute("products", productService.findAll());
        return "shop";
    }

    @GetMapping("add")
    public String addToCart(@RequestParam("id") Long id, RedirectAttributes rd, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        productService.findById(id).ifPresent(cart::addProduct);
        rd.addFlashAttribute("noti", "Đã thêm sản phẩm vào giỏ");
        return "redirect:/shop";
    }

    @GetMapping("detail")
    public String showDetail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id).orElse(null));
        return "detail";
    }

    @GetMapping("shopping-cart")
    public String showCart(Model model, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            session.setAttribute("cart", new Cart());
        }
        model.addAttribute("cart", cart);
        return "cart";
    }

    @RequestMapping("payment")
    public String paymentAndCleanCart(HttpSession session, Model model, @RequestParam(value = "quantity",required = false)int[] quantities) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            return "redirect:/shop";
        }
        int i=0;
        Map<Product,Integer> products =  new HashMap<>();
        for(Product product : cart.getProductList()){
            if(quantities[i]!=0){
                products.put(product,quantities[i]);
            }
            i++;
        }
        cart.setProducts(products);
        model.addAttribute("quantity",cart.countProductQuantity());
        model.addAttribute("total",cart.totalPayment());
        session.invalidate();
        return "payment-success";
    }

    @RequestMapping("remove")
    public String removeProduct(@RequestParam("id")Long id, HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeProduct(productService.findById(id).orElse(null));
        session.setAttribute("cart",cart);
        return "redirect:/shopping-cart";
    }
}
