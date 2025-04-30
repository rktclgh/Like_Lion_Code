// case 1 : 다형성 처리를 구현하는 arguments.length 처리 -> ...args : 모든 매개인자를 배열로 받겠다.

const test = (...args) => {
    switch (args.length) {
      case 0: return 100;                    // 매개변수 없음
      case 1: return args[0];                // 매개변수 1
      case 2: return args[0] + args[1];
      default: return NaN;
    }
  };
  
  console.log(test());
  console.log(test(100));
  console.log(test(100, 200));
  console.log(test(1, 2, 3));
  
  // case 2 : typeof를 이용한 분기 방법
  const test03 = (a, b) => {
    if (typeof a === "undefined" && typeof b === "undefined") return 100;
    if (typeof b === "undefined") return a;
    return a + b;
  };
  
  console.log(test03());
  console.log(test03(100));
  console.log(test03(100, 200));
  