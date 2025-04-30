// case 1 : 내장 클래스 상속 (Extending Built-in Classes)
console.log(" 내장 클래스 상속 ");
class MyArray extends Array {
  shuffle() {
    // 배열 섞는 로직
    for (let i = this.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [this[i], this[j]] = [this[j], this[i]];
    }
    return this;
  }
}

const myArray = new MyArray(1, 2, 3, 4, 5);
myArray.shuffle();
console.log(myArray); 

//case2 : 상속  믹스인 (Mixins) -> 여러 객체의 속성과 메서드를 다른 객체에 복사하여 기능을 혼합하는 패턴
console.log(" Mixins ");
const canWalk = {
  walk: function() {
    console.log(`${this.name}이 걷는다.`);
  }
};

const canSwim = {
  swim: function() {
    console.log(`${this.name}이 수영한다.`);
  }
};

class Person {
  constructor(name) {
    this.name = name;
  }
}

// 믹스인 함수
function mixin(target, ...sources) {
  Object.assign(target.prototype, ...sources);
}

mixin(Person, canWalk, canSwim);

const person = new Person('홍길동');
person.walk(); 
person.swim(); 



//case 3: 컴포지션 (Composition) -> 클래스가 다른 객체를 포함하고, 그 객체의 기능을 활용하는 방식

console.log(" Composition ");
class Walker {
  walk(name) {
    console.log(`${name}이 걷는다.`);
  }
}

class Swimmer {
  swim(name) {
    console.log(`${name}이 수영한다.`);
  }
}

class Athlete {
  constructor(name) {
    this.name = name;
    this.walker = new Walker();
    this.swimmer = new Swimmer();
  }

  walk() {
    this.walker.walk(this.name);
  }

  swim() {
    this.swimmer.swim(this.name);
  }
}

const athlete = new Athlete('멍멍이');
athlete.walk(); 
athlete.swim(); 