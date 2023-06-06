import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../service/category.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {
  rf: FormGroup;

  constructor(private categoryService: CategoryService,
              private router: Router,
              private bd: FormBuilder) {
  }

  ngOnInit(): void {
    this.rf = this.bd.group({
      name: '',
    });
  }

  save() {
    this.categoryService.saveCategory(this.rf.value).subscribe(next => {
        alert('Create successfully. Back to list');
        this.rf.reset();
        this.router.navigateByUrl('/categories/list');
      }, error => {
        alert(error);
      },
      () => {
      });
  }

}
