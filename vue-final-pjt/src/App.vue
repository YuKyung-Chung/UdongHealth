<template>
  <div>
    <header>
      <TheHeaderNav />
    </header>
    <main class="container">
      <div class="row">
        <section class="col-9">

            <RouterView />
        </section>
        <aside class="col-3">
          <LoginForm />
          <TheFavList />
        </aside>
      </div>
    </main>
    <footer>
      <TheFooter />
    </footer>
  </div>
</template>

<script setup>
import TheHeaderNav from "./components/common/TheHeaderNav.vue";
import TheFooter from "./components/common/TheFooter.vue";
import LoginForm from "./components/common/TheLoginForm.vue";
import TheFavList from "./components/common/TheFavList.vue";
</script>

<style  scoped>
</style>