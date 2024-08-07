const category = document.getElementById("category");
const itemListdiv = document.getElementById("itemListdiv");
const wpdiv = document.getElementById("wpdiv");
const option = document.getElementById("option");
const searchbtn = document.getElementById("searchbtn");

let page = 1
let kind = ""
let search = ""

category.addEventListener("change",()=>{
    
    if(category.value == 1){
        option.innerHTML="이름"
    } else {
        option.innerHTML="종족"
    }

    getList(category.value,page,kind,search);
})

getList(0,1,kind,search)

function getList(num, page, kind, search){
    fetch("./itemListRefresh?category="+num+"&page="+page+"&kind="+kind+"&search="+search,{
        method:"get"
    }).then((res)=>res.text())
    .then((res)=>{
        
        itemListdiv.innerHTML=res

    })
    .catch((res)=>{alert("리스트 조회 실패")})
}

itemListdiv.addEventListener("click", (e)=>{

    page = e.target.id

    console.log(page)

    getList(category.value, page, kind, search)
})

searchbtn.addEventListener("click",()=>{


    kind = document.getElementById("kind").value
    search = document.getElementById("search").value

    

    getList(category.value,page,kind,search)

})


