//training finished!
<template>
  <div class="training-finished">
    <dm-heading class="element" tag="h1" weight="bold">Training finished!</dm-heading>
    <dm-heading class="element" tag="p" weight="thin">Training completed!</dm-heading>
    <dm-heading class="element" tag="p" weight="thin">You can continue to train until you answer all questions correctly</dm-heading>
    <dm-button class="element" color="black">Training</dm-button>
    <dm-heading class="element" tag="h5" weight="thin">{{wrongCount}} questions left</dm-heading>
    <br>
    <dm-button class="element">Bonus</dm-button>
    <br class="element">
    <br class="element">
    <br class="element">
    <br class="element">
    <dm-button class="element" color='black' >Skip Training</dm-button>
    <dm-button class="element" color='black' >Finish</dm-button>
  </div>
</template>
<script>
</script>
<style>
html{
  line-height: 1.15;
}
.element{
  margin-bottom: 20pt;
}
.training-finished{
  border: 5px solid #323e4f;
  border-radius: 5px;
  background-color: rgba(40,50,67,.4);
}
</style>
