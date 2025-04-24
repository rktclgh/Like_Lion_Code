var name01 ="홍길동";
var age = 30;
const PI = 3.1415;

console.log("이름",name01);
console.log("나이",age);
console.log("원주율",PI);



a = 100;
b = 200;


hap = a + b;
console.log("a + b",hap);
console.log(typeof 123);
console.log(typeof 90.9);
console.log(typeof []);
console.log(typeof {});
console.log(typeof true);
console.log(typeof null);
console.log(typeof function(){});
console.log(typeof undefined);
console.log(typeof NaN);


console.log( [] instanceof Array);
console.log( {} instanceof Object);
console.log(new Date() instanceof Date);



console. log(Object.prototype.toString.call(null));
 console.log(Object.prototype.toString.call([]));
console.log(Object.prototype.toString.call(new Date));



const sym1 = Symbol("foo");
const sym2 = Symbol("foo");
console.log(sym1 == sym2); // false
console.log(sym1 === sym2); // false
console.log(typeof sym1); // symbol