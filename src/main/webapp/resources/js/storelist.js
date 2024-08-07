const category = document.getElementById("category");
const itemListdiv = document.getElementById("itemListdiv");
const option = document.getElementById("option");
const searchbtn = document.getElementById("searchbtn");

let page = 1
let num = 0
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

getList(num,page,kind,search)

function getList(num, page, kind, search){
    
    fetch("./itemListRefresh?category="+num+"&page="+page+"&kind="+kind+"&search="+search,{
        method:"get"
    }).then((res)=>res.text())
    .then((res)=>{
        
        itemListdiv.innerHTML=res

        

    }).catch(()=>{alert("리스트 조회 실패")})
}

itemListdiv.addEventListener("click", (e)=>{

    if(e.target.classList.contains("pagenum")){
        page = e.target.getAttribute("data-num");
        getList(category.value, page, kind, search)
    }

    console.log(page)

})

searchbtn.addEventListener("click",()=>{

    kind = document.getElementById("kind").value
    search = document.getElementById("search").value

    getList(category.value,page,kind,search)

})


