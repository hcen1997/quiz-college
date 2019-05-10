<template>
    <div>
        the message is {{message}}
    </div>
</template>
<script>
export default {
  name: 'Message',
  props: {
    message: String
  }
}
</script>
