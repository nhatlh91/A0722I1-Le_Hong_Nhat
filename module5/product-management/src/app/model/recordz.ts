import {Patient} from './patient';

export interface Recordz {
  id?: number;
  patient?: Patient;
  in?: string;
  out?: string;
  reason?: string;
  solution?: string;
  doctor?: string;
}
