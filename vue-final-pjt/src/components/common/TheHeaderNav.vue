<template>
    <div class="main-container">
        <nav class="navbar navbar-expand-lg" style="background-color: #67BA6A">
            <div class="logo">
                <img src="@/assets/logo.png" alt="Logo" width="50" height="50" class="d-inline-block align-text-top">
                <h1 class="title" >우리 동네 무료 헬스장</h1>
            </div>
            <div class="nav-container">
                <ul class="nav nav-underline">
                    <li class="nav-item">
                        <RouterLink to="/" class="nav-link">Home</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink to="/about" class="nav-link">About us</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink to="/search" class="nav-link">Search</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink to="/kind" class="nav-link">Kind</RouterLink>
                    </li>
                </ul>
            </div>
        </nav> 
    </div>
</template>

<script setup>
import { onMounted } from 'vue'
import { useRouter } from 'vue-router'


const router = useRouter();

onMounted(() => {
    router.replace("/");
})

</script>

<style  scoped>
.main-container {
    color:whitesmoke;
    font-family: 'Pretendard-Regular';
}

.logo{
    display: flex;
    align-items: center;
    margin: 10px;
}

img{
    margin-right: 10px;
}


.nav-container {
    margin-left: auto;
    font-weight: 700;
}

.title{
    font-weight: 700;
    font-size: 25px;
    text-align: left;
}

a {
    text-decoration-line: none;
    color: whitesmoke;
}


.mainTitle {
    margin-top: 30px;
    display : inline-block;
    background: linear-gradient(to top, #54ddff 20%, transparent 30%);
    font-family: 'JalnanGothic';
}
</style>