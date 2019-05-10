<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <Header systemName="公务员"/>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <Footer />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Header from '@/components/Header.vue'
import Footer from '@/components/Footer.vue'
import Message from '@/components/Message.vue'
export default {
  name: 'home',
  components: {
    HelloWorld,
    Header,
    Footer,
    Message
  }
}
</script>
