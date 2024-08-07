const category = document.getElementById("category");
const itemListdiv = document.getElementById("itemListdiv");
const wpdiv = document.getElementById("wpdiv");
const kind = document.getElementById("kind");

let page = 1

category.addEventListener("change",()=>{
    
    if(category.value == 1){
        console.log(kind.value)
        
    }

    getList(category.value,page);
})

getList(0,1)

function getList(num, page){
    fetch("./itemListRefresh?category="+num+"&page="+page,{
        method:"get"
    }).then((res)=>res.text())
    .then((res)=>{
        
        itemListdiv.innerHTML=res

    })
    .catch((res)=>{alert("리스트 조회 실패")})
}

itemListdiv.addEventListener("click", (e)=>{

    page = e.target.id

    getList(category.value, page)
})


