// function uploadFile () { return "File Uploaded Successfully"; }
// let uploadFile = function(){ return "File Uploaded Successfully"; };
// It can be written this way below:
let uploadFile = async() => "File Uploaded Successfully";

let updateUserProfile = () => {
    let result = uploadFile();
    console.log("Result is:  " + result);
}

updateUserProfile();
// For code below to work, I need Promise API files
// const fetchPromise = fetch(
//     "https://mdn.github.io/learning-area/javascript/apis/fetching-data/can-store/products.json",
//   );
  
//   console.log(fetchPromise);
  
//   fetchPromise.then((response) => {
//     console.log(`Received response: ${response.status}`);
//   });
  
//   console.log("Started request…");

