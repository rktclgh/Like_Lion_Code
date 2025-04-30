console.log(x);// undefined

var x = 5;
console.log(x); 


/*
var x;
console.log(x); // undefined
x = 5;
console.log(x); // 5
// var 키워드로 선언된 변수는 호이스팅이 발생한다.
*/ 

prn(); // undefined

function prn()
{
    console.log("============prn============")
}

sayHello();

var sayHello = function()
{
    console.log("hello");
}