<template>
  <div id="app">
    <Header title="Desafio CRUD Leigado"/>
    <Content />
    <Footer />
  </div>
</template>

<script>

import Header from '@/components/template/Header'
import Content from '@/components/template/Content'
import Footer from '@/components/template/Footer'

export default {
  name: 'App',
  components: { Header, Content, Footer }
}
</script>

<style>
body {
  margin: 0;
}

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

  height: 100vh;
  display: grid;
  grid-template-rows: 60px 1fr 40px;
  grid-template-areas: 
    'header'
    'content'
    'footer'

}
</style>
