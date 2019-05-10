<template>
    <div>
  <dm-button
    color="black"
  >{{msg}}</dm-button>
    </div>
    <!-- loding="false" -->
    <!-- left-icon= -->
    <!-- rounded="true" -->
</template>
<script>
export default {
  name: 'DarkBtn',
  props: {
    msg: String
  }
}
</script>
