import { environment } from 'src/environments/environment';

const PATH_SERVER = environment.path;
const PORT = environment.port;

export const FIXED_ASSET_ENDPOINTS = {
    findById: PATH_SERVER + PORT + '/api/fixedAsset/',
    searchByFilter: PATH_SERVER + PORT + '/api/fixedAsset/searchByFilter',
    saveFixedAsset: PATH_SERVER + PORT + '/api/fixedAsset/save'
};