import { environment } from 'src/environments/environment';

const PATH_SERVER = environment.path;
const PORT = environment.port;

export const AREA_ENDPOINTS = {
    listAreas: PATH_SERVER + PORT + '/api/area/findAll'
};
