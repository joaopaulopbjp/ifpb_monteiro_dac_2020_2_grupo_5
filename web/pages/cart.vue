<template>
  <v-layout>
    <v-col>
      <h1>Your Cart</h1>
      <v-col class="justify-center">
        <v-layout
          row
          wrap
          align-end
          class="padding-content"
        >
          <Product
            v-for="(product, i) in products"
            :key="i"
            :title="product.title"
            :price="product.price"
            class="margin"
          />
        </v-layout>
      </v-col>
    </v-col>
  </v-layout>
</template>
<script>
export default {
  data () {
    return {
      products: [
        {
          title: 'book1',
          price: 10.5
        },
        {
          title: 'book3',
          price: 10.5
        },
        {
          title: 'book2',
          price: 10.5
        },
        {
          title: 'book3',
          price: 10.5
        },
        {
          title: 'book2',
          price: 10.5
        },
        {
          title: 'book3',
          price: 10.5
        },
        {
          title: 'book2',
          price: 10.5
        },
        {
          title: 'book3',
          price: 10.5
        },
        {
          title: 'book2',
          price: 10.5
        }
      ]
    }
  }
}
</script>
<style scoped>
  .justify-center{
    justify-content: center;
  }
  .padding-content{
    justify-content: space-between;
    align-content: space-around;
  }
  .margin{
    margin: 10px 0;
  }
</style>
