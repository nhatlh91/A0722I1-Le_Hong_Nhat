import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';
import {Router} from '@angular/router';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {
  categories: Category[] = [];

  constructor(private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.getAll();
  }
  getAll() {
    this.categoryService.getAll().subscribe(item => {
      this.categories = item;
    });
  }
  delete(id: number) {
    this.categoryService.deleteCategory(id).subscribe( next => {
      alert('Xoá thành công');
      this.getAll();
    });
  }
}
