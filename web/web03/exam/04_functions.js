function test()
{
  return 100;
}

function test(a)
{
  return a;
}

function test(a,b)
{
  return a+b;
}

//함수 오버로딩이 없다 !!! -> 동일한 이름의 함수는 나중에 선언된 함수로 덮어 쓰기 된다.
console.log(test()); // 100
console.log(test(10)); // 10
console.log(test(10,20)); // 30


//함수 오버로딩이 없다 !!! -> 동일한 이름의 함수는 나중에 선언된 함수로 덮어 쓰기 된다.
function test02(a,b)
{
  if(a == undefined && b == undefined)
    return 100;
  if(b == undefined)
  {
    return a;
  }
  return a + b;
}


console.log(test02()); // 100
console.log(test02(10)); // 10
console.log(test02(10,20)); // 30


console.log("----------------람다식으로 변경-----------------");

const test03 = (a,b) =>
{
  if(a == undefined && b == undefined)
    return 100;
  if(b == undefined)
  {
    return a;
  }
  return a + b;
}

console.log(test03()); // 100
console.log(test03(10)); // 10
console.log(test03(10,20)); // 30


console.log(" ----------------한줄로 변경-----------------");
const test04 = (a,b) => a == undefined && b == undefined ? 100 : b == undefined ? a : a + b;
console.log(test04()); // 100
console.log(test04(10)); // 10
console.log(test04(10,20)); // 30

// const func = (param) => expression


