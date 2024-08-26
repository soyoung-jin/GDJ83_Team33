const makeFriendBtn = document.getElementById("makeFriendBtn");
const friendDetail = document.getElementById("friendDetail");
//상대방 id
let user_id = makeFriendBtn.getAttribute("data-user-id");

const pet_num = document.getElementById("pet_num").value;
console.log(user_id);
console.log(pet_num);

//내 아이디거나 이미 친구면 "친구 추가" 버튼 안보이게
if(friendDetail != null || userId == user_id) {
    makeFriendBtn.style.display = "none";
} 


// makeFriendBtn.addEventListener("click", ()=>{
//     alert("hi");
//     fetch("/friend/makeFriend?user_id=" + user_id , {
//         method: "GET"
//     })
//     .then(r=>{return r.text})
//     .then((r)=>{
//         r.trim;
//         if(r>0) {
//             alert("친구 추가 성공");
//             location.href="/rank/rankDetail?pet_num=" + pet_num;
//         }
//     })
//     .catch(()=>{
//         alert("오류");
//     })
// })