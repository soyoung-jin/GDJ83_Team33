const category = document.getElementById("category");
const itemListdiv = document.getElementById("itemListdiv");
const option = document.getElementById("option");
const searchbtn = document.getElementById("searchbtn");

let search = document.getElementById("search").value;
let kind = document.getElementById("kind").value;
let page = 0;

function getList(category_num, page, kind, search){
    
    fetch("./itemListRefresh?category_num="+category_num+"&page="+page+"&kind="+kind+"&search="+search,{
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

})

searchbtn.addEventListener("click",()=>{

    search = document.getElementById("search").value;
    kind = document.getElementById("kind").value;

    getList(category.value,page,kind,search)

})

//wishlist

itemListdiv.addEventListener("click",(e)=>{
    if(e.target.classList.contains("addwish")){

        let item_num = e.target.getAttribute("data-inum")

        fetch("addWishList?item_num="+item_num,{
            method:"GET"
        })
        .then(r=>r.text())
        .then(r=>{

            if(r>0){
                let check = confirm("찜목록으로 가시겠습니까?")
    
                if(check){
                    location.href="getwishList"
                }
            } else if(r<0){
                alert ("로그인 ㄱㄱ")
            } else {
                alert ("추가 실패")
            }

        }).catch(()=>{alert("추가 실패")})

    }
})


