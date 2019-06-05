export type ValidItemType = 'inapp' | 'subs';

export interface QueryResponse {
  responseCode: number,
  results: Array<Purchase | ItemDetails>,
}

export interface Purchase {
  acknowledged: boolean,
  orderId: string,
  productId: string,
  purchaseState: number,
  purchaseTime: number,
  packageName: string, // Android only
  purchaseToken?: string // Android only
  transactionReceipt?: string // iOS only
}

export interface ItemDetails {
  description: string,
  price: string,
  priceAmountMicros: number,
  priceCurrencyCode: string,
  productId: string,
  title: string,
  type: ValidItemType,
  subscriptionPeriod?: string
  skuDetailsToken?: string // Android only
}