<template>
    <div class="container">
        <RouterLink to="/kind">전체</RouterLink>
        |
        <RouterLink to="upperBody">상체</RouterLink>
        |
        <RouterLink to="lowerBody">하체</RouterLink>
        |
        <RouterLink to="core">복부</RouterLink>
        |
        <RouterView/>

    </div>
</template>

<script setup>

</script>

<style scoped>
a {
    text-decoration-line: none;
}
</style>