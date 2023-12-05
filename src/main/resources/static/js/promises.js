// let's create a promise that divides two numbers
let promise = new Promise(function(resolve, reject){
    //inside the executor stored in the promise
    let num = prompt('Enter a numerator');
    let den = prompt('Enter a denominator');


    //covnert to anumbers
    num= parseFloat(num);
    den = parseFloat(den);

    //check for bad inputs
    if(Number.isNaN(num) || Number.isNaN(den))
    {
        throw Error("User entered non numerical symbols");
    }

    if(den === 0)
    {
        reject("Cannot divide by zero.")
    }
    else
    {
        let result = num/den;
        //report success by using the first parameter (which ius a function
        resolve("Result is  " + result);
    }

});

promise
    .then(function (success){
        console.log("The promise was succesful");
        console.log(success);
    },function (failure){
        console.log("The promise was unsuccesful");
        console.log(failure);
    })
    .catch(function (error){
        console.log("Something went wrong");
        console.log(error);
    });