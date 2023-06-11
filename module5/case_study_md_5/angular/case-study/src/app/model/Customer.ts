import {CustomerType} from './customer-type';

export interface Customer {
  id?: number;
  customerCode?: string;
  customerName?: string;
  birthday?: string;
  gender?: string;
  idNumber?: string;
  phone?: string;
  email?: string;
  type?: CustomerType;
  address?: string;
}
