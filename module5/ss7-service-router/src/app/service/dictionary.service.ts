import {Injectable} from '@angular/core';
import {Word} from '../model/word';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  list: Word[] = [
    {
      word: 'hello',
      mean: 'xin chào'
    },
    {
      word: 'dog',
      mean: 'con chó'
    },
    {
      word: 'revenge',
      mean: 'báo thù'
    },
    {
      word: 'mouse pad',
      mean: 'lót chuột'
    },
    {
      word: 'money',
      mean: 'tiền'
    },
    {
      word: 'subscribe',
      mean: 'đăng ký'
    },
  ];

  constructor() {
  }

  translate(keyword: string) {
    let result = null;
    this.list.forEach((item) => {
        if (item.word === keyword.toLowerCase()) {
          result = item;
        }
      }
    );
    return result;
  }
}
