<template>
  <div id="app">
    <div id="nav" v-if="false">
      <router-link to="/">Home</router-link>|
      <router-link to="/about">About</router-link>
      <br>
      <router-link to="/training/start">start</router-link>|
      <router-link to="/training/body">body</router-link>|
      <router-link to="/training/finished">finished</router-link>|
      <router-link to="/training/result">result</router-link>
      <br>
      <router-link to="/bonus/choose">bounsChoose</router-link>
    </div>
    <router-view/>
  </div>
</template>
<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 30px;
}
html {
  background-color: #1c2532;
  text-align: center;
  word-spacing: 1px;
  font-size: 16px;
  font-family: Heebo, Helvetica Neue, Source Sans Pro, Helvetica, Arial,
    sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  -webkit-text-size-adjust: 100%;
  -ms-text-size-adjust: 100%;
}
</style>
