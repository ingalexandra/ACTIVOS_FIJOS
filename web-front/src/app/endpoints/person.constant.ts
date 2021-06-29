import { environment } from 'src/environments/environment';

const PATH_SERVER = environment.path;
const PORT = environment.port;

export const PERSON_ENDPOINTS = {
    listPeople: PATH_SERVER + PORT + '/api/person/findAll'
};