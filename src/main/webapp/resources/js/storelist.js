const category = document.getElementById("category");
const storeItemList = document.getElementById("storeItemList")

category.addEventListener("change",()=>{
    
    console.log(category.value)

    // location.href="itemList?category="+category.value;
})

getList(1)

function getList(num){

    fetch("itemList?category="+num,{
        method:"get"
    }).then((r)=>{
        r.text()
    })
    .then((r)=>{
        storeItemList.innerHTML=r;
    })

}
