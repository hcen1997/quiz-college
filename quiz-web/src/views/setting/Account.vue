<template>
    <div>
        <h1>用户设置</h1><br>
        用户名: {{this.$store.state.person.name}}<br>
        <br>
      <br>
        <router-link to="/setting">
        <dm-button>返回</dm-button>
        </router-link>
    </div>
</template>
