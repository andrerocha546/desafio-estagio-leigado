<template>
  <div id="form">
    <b-form>
      <input type="hidden" id="user-id" v-model="user.id" />
      <b-row>
        <b-col md="6" sm="12">
          <b-form-group label="Nome:" label-for="user-name">
            <b-form-input
              id="user-name"
              type="text"
              v-model="user.name.name"
              required
              placeholder="Informe o nome do Usuário"
            />
          </b-form-group>
        </b-col>
        <b-col md="6" sm="12">
          <b-form-group label="Email:" label-for="user-email">
            <b-form-input
              id="user-email"
              type="text"
              v-model="user.email.email"
              required
              placeholder="Informe o E-mail do Usuário"
            />
          </b-form-group>
        </b-col>
      </b-row>
      <b-row>
        <b-col md="6" sm="12">
          <b-form-group label="Senha:" label-for="user-password">
            <b-form-input
              id="user-password"
              type="password"
              v-model="user.password.password"
              required
              placeholder="Informe a Senha do Usuário"
            />
          </b-form-group>
        </b-col>
      </b-row>
      <b-row>
        <b-col vs="12">
          <b-button variant="primary" @click="save">Salvar</b-button>
          <b-button variant="danger" @click="remove" v-if="mode == 'update'">Excluir</b-button>
          <b-button class="ml-2" @click="reset">Cancelar</b-button>
        </b-col>
      </b-row>
    </b-form>
    <hr />
    <b-table hover striped :items="users" :fields="fields">
      <template #cell(actions)="row">
        <b-button variant="warning" @click="loadUser(row.item)" class="mr-2">
            <em class="fa fa-pencil"></em>
        </b-button>
        <b-button variant="danger" @click="remove(loadUser(row.item))" class="mr-2">
            <em class="fa fa-trash"></em>
        </b-button>
      </template>
    </b-table>
  </div>
</template>

<script>
import axios from "axios";
import { baseApiUrl } from "@/global";

export default {
  name: "Form",
  data: function () {
    return {
      users: [],
      mode: "save",
      user: {
        name: {},
        email: {},
        password: {},
      },
      fields: [
        { key: "id", label: "Código", sortable: true },
        { key: "name", label: "Nome", sortable: true },
        { key: "email", label: "E-mail", sortable: true },
        { key: "actions", label: "Ações" },
      ],
    };
  },
  methods: {
    loadUsers() {
      const url = `${baseApiUrl}/users`;
      axios.get(url).then((res) => {
        this.users = res.data;
      });
    },
    save() {
      let method = "";
      if(this.user.id) {
        method = "put"
        this.mode = "update"
      } else {
        method = "post"
      }
      const id = this.user.id ? `${this.user.id}` : "";
      console.log(this.user)
      axios[method](`${baseApiUrl}/users/${id}`, this.user).then(() => {
        this.reset();
      });
      console.log(this.user);
    },
    reset() {
      this.mode = "save";
      this.user = {
        name: {},
        email: {},
        password: {},
      };
      this.loadUsers();
    },
    remove() {
      const id = this.user.id;
      axios.delete(`${baseApiUrl}/users/${id}`)
        .then(() => {
          this.reset();
        });
    },
    loadUser(user) {
      this.mode = "update";
      this.user = {
        id: user.id,
        name: {name: user.name},
        email: {email: user.email},
        password: {password: user.password}
      };
    },
  },
  mounted() {
    this.loadUsers();
    this.reset();
  },
};
</script>
