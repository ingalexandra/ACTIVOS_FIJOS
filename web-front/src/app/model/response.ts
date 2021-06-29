export interface IResponse<T> {
    data: T;
    code: string;
    description: string;
}
