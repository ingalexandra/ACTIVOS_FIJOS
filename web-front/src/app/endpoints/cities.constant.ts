import { environment } from 'src/environments/environment';

const PATH_SERVER = environment.path;
const PORT = environment.port;

export const CITY_ENDPOINTS = {
    listCities: PATH_SERVER + PORT + '/api/city/findAll'
};