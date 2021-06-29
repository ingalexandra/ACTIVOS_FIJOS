import { environment } from 'src/environments/environment';

const PATH_SERVER = environment.path;
const PORT = environment.port;

export const TYPE_ASSET_ENDPOINTS = {
    listTypes: PATH_SERVER + PORT + '/api/typeAsset/findAll'
};
