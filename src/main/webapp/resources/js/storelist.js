const category = document.getElementById("category");
const itemListdiv = document.getElementById("itemListdiv")

category.addEventListener("change",()=>{
    
    getList(category.value);

    
})

getList(0)

function getList(num){
    fetch("./itemListRefresh?category="+num,{
        method:"get"
    }).then((res)=>res.text())
    .then((res)=>itemListdiv.innerHTML=res)

}
