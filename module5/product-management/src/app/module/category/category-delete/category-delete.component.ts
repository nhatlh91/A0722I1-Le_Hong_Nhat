import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../../service/category.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Category} from '../../../model/category';

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {
  constructor(private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(param => {
      const id = parseInt(param.get('id'), 10);
      this.categoryService.deleteCategory(id).subscribe(next => {
        this.router.navigateByUrl('/categories/list');
        alert('Deleted successfully');
      });
    });
  }
}
