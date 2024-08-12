const delwish = document.getElementById("delwish")
const del = document.getElementsByClassName("delbtn")


// delwish.addEventListener("click",(e)=>{

    
//     if(e.target.classList.contains("delbtn")){
//         console.log(e.target)
        
//         // let wsnum = e.target.getAttribute("data-wnum")

//         // console.log(wsnum)

//         // fetch("deleteWishList?wishlist_num="+wsnum,{
//         //     method:"GET"
//         // }).then((res)=>res.text())
//         // .then((res)=>{

//         //     delwish.innerHTML=res
//         // }).catch(()=>{alert("삭제 실패!")})
            
//     }
// })
    

for(d of del) {
    d.addEventListener("click", (e)=>{
        console.log(d)

        
        console.log(d.getAttribute("data-wnum"))
    })
}