const fileAddButton = document.querySelector(".add-button");
const fileInput = document.querySelector(".file-input");
const submitButton = document.querySelector(".submit button");

let productImagesFiles = new Array();



fileAddButton.onclick = () => {
    fileInput.click();
}

fileInput.onchange = () => {
    const formDate = new FormData(document.querySelector("form"));

    formDate.forEach((value) => {
        if(value.size != 0) {
            productImagesFiles.push(value); 
            console.log(productImagesFiles);
            getImagePreview();
            fileInput.value = null;//값을 비워줌
        }
            
    });
}


function getImagePreview() {
    const productImages = document.querySelector(".product-images");

    productImages.innerHTML = "";

    productImagesFiles.forEach((file, i) => {
     
        const reader = new FileReader();
        
        reader.onload = (e) => {
            productImages.innerHTML += `
                <div class="img-box">
                    <i class="fa-solid fa-xmark"></i>
                    <img class="product-img" src="${e.target.result}">
                </div>  
            `;
            
            const deletButton = document.querySelectorAll(".fa-xmark");
            deletButton.forEach((xbutton, index) => {
                xbutton.onclick = () => {
                    if(confirm("상품 이미지를 지우시겠습니까?")) {
                        productImagesFiles.splice(index, 1);
                        getImagePreview();
                    }
                };
            })
          
            

        }
        //동기 - 바로 응답
        //setTimeout - 비동기 처리 ex). AJSON 
        setTimeout(reader.readAsDataURL(file), i * 100);

        
    });
}















































