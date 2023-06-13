import {Employee} from './employee';
import {Customer} from './Customer';
import {Facility} from './facility';

export interface Contract {
  id?: number;
  employee?: Employee;
  customer?: Customer;
  facility?: Facility;
  beginDate?: string;
  endDate?: string;
  deposit?: number;
  totalAmount?: number;
}
