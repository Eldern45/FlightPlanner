<template>
  <div id="app">
    <h1>FLights List:</h1>
    <div>
      <label for="sortSelect">Sort by:</label>
      <select id="sortSelect" v-model="selectedSort" @change="fetchFlights">
        <option value="">Default</option>
        <option value="departure_date">Departure date</option>
        <option value="duration">Flight duration</option>
        <option value="price">Price</option>
      </select>

      <button v-if="selectedSort" @click="toggleSortOrder" class="sort-toggle">
        <span v-if="sortOrder === 'asc'">▲</span>
        <span v-else>▼</span>
      </button>
    </div>
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>From</th>
        <th>Where</th>
        <th>Departure date</th>
        <th>Arrival date</th>
        <th>Duration</th>
        <th>Price</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="flight in flights" :key="flight.id">
        <td>{{ flight.id }}</td>
        <td>{{ flight.departurePlace }}</td>
        <td>{{ flight.arrivalPlace }}</td>
        <td>{{ formatTime(flight.departureTime) }}</td>
        <td>{{ formatTime(flight.arrivalTime) }}</td>
        <td>{{ flight.flightDuration }}</td>
        <td>{{ flight.price }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  name: "App",
  data() {
    return {
      flights: [],
      selectedSort: "",
      sortOrder: "asc"
    };
  },
  created() {
    this.fetchFlights();
  },
  methods: {
    fetchFlights() {
      let url = "http://localhost:8080/api/flights";
      if (this.selectedSort) {
        url += `?sort=${this.selectedSort}&order=${this.sortOrder}`;
      }
      fetch(url)
          .then(response => response.json())
          .then(data => {
            this.flights = data;
          })
          .catch(error => {
            console.error("Ошибка при загрузке рейсов:", error);
          });
    },
    formatTime(timestamp) {
      if (!timestamp) return "";
      const date = new Date(timestamp);
      return date.toLocaleString("ru-RU", {
        year: "numeric",
        month: "2-digit",
        day: "2-digit",
        hour: "2-digit",
        minute: "2-digit"
      });
    },
    toggleSortOrder() {
      this.sortOrder = this.sortOrder === 'asc' ? 'desc' : 'asc';
      this.fetchFlights();
    }
  }
};
</script>

<style>
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 1em;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
}

.sort-toggle {
  background: none;
  border: none;
  font-size: 18px;
  cursor: pointer;
  margin-left: 10px;
}
</style>


<style>
table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 1em;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
}
</style>




<!--<script setup>-->
<!--import { RouterLink, RouterView } from 'vue-router'-->
<!--import HelloWorld from './components/HelloWorld.vue'-->
<!--</script>-->

<!--<template>-->
<!--  <header>-->
<!--    <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />-->

<!--    <div class="wrapper">-->
<!--      <HelloWorld msg="You did it!" />-->

<!--      <nav>-->
<!--        <RouterLink to="/">Home</RouterLink>-->
<!--        <RouterLink to="/about">About</RouterLink>-->
<!--      </nav>-->
<!--    </div>-->
<!--  </header>-->

<!--  <RouterView />-->
<!--</template>-->

<!--<style scoped>-->
<!--header {-->
<!--  line-height: 1.5;-->
<!--  max-height: 100vh;-->
<!--}-->

<!--.logo {-->
<!--  display: block;-->
<!--  margin: 0 auto 2rem;-->
<!--}-->

<!--nav {-->
<!--  width: 100%;-->
<!--  font-size: 12px;-->
<!--  text-align: center;-->
<!--  margin-top: 2rem;-->
<!--}-->

<!--nav a.router-link-exact-active {-->
<!--  color: var(&#45;&#45;color-text);-->
<!--}-->

<!--nav a.router-link-exact-active:hover {-->
<!--  background-color: transparent;-->
<!--}-->

<!--nav a {-->
<!--  display: inline-block;-->
<!--  padding: 0 1rem;-->
<!--  border-left: 1px solid var(&#45;&#45;color-border);-->
<!--}-->

<!--nav a:first-of-type {-->
<!--  border: 0;-->
<!--}-->

<!--@media (min-width: 1024px) {-->
<!--  header {-->
<!--    display: flex;-->
<!--    place-items: center;-->
<!--    padding-right: calc(var(&#45;&#45;section-gap) / 2);-->
<!--  }-->

<!--  .logo {-->
<!--    margin: 0 2rem 0 0;-->
<!--  }-->

<!--  header .wrapper {-->
<!--    display: flex;-->
<!--    place-items: flex-start;-->
<!--    flex-wrap: wrap;-->
<!--  }-->

<!--  nav {-->
<!--    text-align: left;-->
<!--    margin-left: -1rem;-->
<!--    font-size: 1rem;-->

<!--    padding: 1rem 0;-->
<!--    margin-top: 1rem;-->
<!--  }-->
<!--}-->
<!--</style>-->
