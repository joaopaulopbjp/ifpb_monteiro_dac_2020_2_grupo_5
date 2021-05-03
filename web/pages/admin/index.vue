<template>
  <Admin>
    <v-layout v-if="!edit">
      <v-col>
        <v-col class="justify-center">
          <v-layout
            row
            wrap
            align-end
            class="padding-content"
          >
            <BookAdmin
              v-for="(book, i) in books"
              :key="i"
              :title="book.title"
              :price="book.price"
              :stock="book.stock"
            />
          </v-layout>
        </v-col>
        <br>
        <v-pagination
          v-model="page"
          :length="4"
          circle
        />
      </v-col>
    </v-layout>
    <v-layout v-else>
      <v-col class="justify-center">
        <v-layout
          row
          wrap
          align-end
          class="padding-content"
        >
          <BookAdmin
            :title="title"
            :price="price"
            :stock="stock"
          />
        </v-layout>
      </v-col>
    </v-layout>
  </Admin>
</template>

<script>
import Admin from '~/layouts/admin.vue'
import BookAdmin from '~/components/BookAdmin'
export default {
  components: {
    BookAdmin
  },
  data () {
    return {
      books: [
        {
          title: 'Title',
          price: 11,
          stock: 15
        },
        {
          title: 'book2',
          price: 11.0,
          stock: 15
        },
        {
          title: 'Till',
          price: 11,
          stock: 15
        }
      ],
      page: 1,
      edit: false
    }
  },
  template: {
    Admin
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
