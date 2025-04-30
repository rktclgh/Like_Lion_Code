// export : 하나의 모듈에 하나의 기본값으로 지정 , class, const, function

export const PI = 3.14;

export function add(a, b) { return a + b; }

export class Person {
  constructor(tname, taddress, phone) {
    this.tname = tname;
    this.taddress = taddress;
    this.phone = phone;
  }

  printInfo() {
    console.log(`${this.tname} ${this.taddress} ${this.phone}`);
  }

  toString() {
    return `${this.tname} ${this.taddress} ${this.phone}`;
  }
}

const p1 = new Person('111', '111', '1111');
p1.printInfo();
console.log(p1 + " "); // 문자열 연산형식으로 " "를 붙여서 출력 → toString() 자동 호출
console.log(p1);

const p_list = [
  new Person('111', '111', '1111'),
  new Person('222', '111', '1111'),
  new Person('333', '111', '1111')
];
