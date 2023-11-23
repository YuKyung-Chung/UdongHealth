<template>
    <div class="container px-4 px-lg-5">
    <div class="row imageContainer">
        <div class="col images hover-effect" @click="openNewWindow(`yhC-key`)">
            <img src="../assets/yhC.png" width="300" class="hover-effect"/>
           
        </div>

        <div class="col images" @click="openNewWindow(`YuKyung-Chung`)">
            <img src="../assets/ykC.png" width="300" class="hover-effect"/>
        </div>

    </div>
</div>
</template>

<script setup>


const openNewWindow = (id) => {
    window.open(`https://github.com/${id}`);
}


</script>

<style scoped>
.imageContainer {
    display: flex;
}
.images {
    display : flex;
    justify-content: center;
    align-items: center;
    height: 75.7vh;


}
.hover-effect:hover {
    cursor: pointer;
}

</style>