import {Category} from './category';

export interface Product {
  id?: number;
  name?: string;
  price?: number;
  description?: string;
  category?: Category;
  purchasingDate?: string;
}
