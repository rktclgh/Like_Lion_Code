 function Hello() {
  return <h1>Hello, React!</h1>;
}

 function Bye()
{
    return <h1>Bye, React! 또만나!!!! 888888888</h1>;

}
 function Connect()
{
  return <h1>Hello, React! Connect !!! 999999</h1>
}


export {Hello as default, Bye, Connect};





//비추천
// export default function Hello() {
//   return <h1>Hello, React!</h1>;
// }

// export function Bye()
// {
//     return <h1>Bye, React! 또만나!!!! 888888888</h1>;

// }
// export function Connect()
// {
//   return <h1>Hello, React! Connect !!! 999999</h1>
// }