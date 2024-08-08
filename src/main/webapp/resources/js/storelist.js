const category = document.getElementById("category");
const itemListdiv = document.getElementById("itemListdiv");
const option = document.getElementById("option");
const searchbtn = document.getElementById("searchbtn");

let search = document.getElementById("search").value;
let kind = document.getElementById("kind").value;
let page = 0;

// getList(category.getAttribute("data-cat-num"),1,kind,search)

function getList(category_num, page, kind, search){
    
    fetch("./itemListRefresh?category_num="+category_num+"&page="+page+"&kind="+kind+"&search="+search,{
        method:"get"
    }).then((res)=>res.text())
    .then((res)=>{
        
        itemListdiv.innerHTML=res

    }).catch(()=>{alert("리스트 조회 실패")})
}

// category.addEventListener("change",()=>{

//     getList(category.value,page,kind,search);

// })

itemListdiv.addEventListener("click", (e)=>{

    if(e.target.classList.contains("pagenum")){
        page = e.target.getAttribute("data-num");
        getList(category.value, page, kind, search)
        
    }

})

searchbtn.addEventListener("click",()=>{

    search = document.getElementById("search").value;
    kind = document.getElementById("kind").value;

    getList(category.value,page,kind,search)

})


