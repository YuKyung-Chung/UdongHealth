<template>
    <form class="col">
        <div class="row-auto">
            <label for="staticId1">Id</label>
            <input type="text" class="form-control" id="staticId1" placeholder="id">
        </div>
        <div class="row-auto">
            <label for="inputPassword2">Password</label>
            <input type="password" class="form-control" id="inputPassword2" placeholder="Password">
        </div>
        
        <div class="row-auto">
            <button type="submit" class="btn btn-primary mb-3">로그인</button>
            <RouterLink to="/signup"> 회원가입 </RouterLink> 
            
        </div>

    </form>
</template>

<script setup>

</script>

<style scoped>
.btn {
    margin-top : 5px;
}
</style>