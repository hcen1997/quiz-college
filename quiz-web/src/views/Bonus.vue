//training finished so get booooooooooooooooooooooooooooooooonus
<template>
  <div class="bouns-choose">
    <dm-heading class="element" tag="h1" weight="bold">Bouns</dm-heading>
    <!-- //gift button -->
    <dm-button class="element" color='black' >1</dm-button>
    <dm-button class="element" color='black' >2</dm-button>
    <dm-button class="element" color='black' >3</dm-button>
    <br>
    <dm-button class="element" color='black' >4</dm-button>
    <dm-button class="element" color='black' >5</dm-button>
    <dm-button class="element" color='black' >6</dm-button>
    <br>
    <dm-button class="element" color='black' >7</dm-button>
    <dm-button class="element" color='black' >8</dm-button>
    <dm-button class="element" color='black' >9</dm-button>
    <!-- change to all open status and show hidden -->

    <dm-heading class="element" tag="h4" weight="bold">Choose</dm-heading>
    <!-- changed status :  -->
    <dm-heading class="element" tag="h4" weight="bold">{{bonusName}}</dm-heading>
    <dm-heading class="element" tag="h4" weight="bold">{{bonusThing}}</dm-heading>
    <br class="element">
    <br class="element">
    <br class="element">
    <br class="element">
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
