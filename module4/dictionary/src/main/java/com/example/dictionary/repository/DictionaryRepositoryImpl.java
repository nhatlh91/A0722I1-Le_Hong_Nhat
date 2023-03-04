package com.example.dictionary.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository{
    private static Map<String,String> data = new HashMap<>();
    static {
        data.put("hello","chào");
        data.put("Bye","tạm biệt");
        data.put("moon","mặt trăng");
        data.put("star","ngôi sao");
        data.put("lamp","bóng đèn");
        data.put("mouse","con chuột");
        data.put("cat","con mèo");
        data.put("dog","con chó");
        data.put("black","màu đen");
    }
    @Override
    public String search(String input) {
        return data.getOrDefault(input, "Không tồn tại");
    }
}
