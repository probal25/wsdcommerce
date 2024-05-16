How to run application
----------------------

1. First clone the project with `git clone`
2. Go to `docker` location
2. Run Bash script to build Docker-Compose images: `./build-docker.sh`
3. Go to `docker/app` location (where `docker-compose.yml` is located)
4. Run Docker-Compose command to create and start application and database: `docker-compose up -d`
5. Run Docker-Compose command to stop and destory application and database: `docker-compose down`


# API Documentation

**Base URL**: `localhost:8080`

## Endpoints

### Wish List Endpoints

#### Get Wish List

- **URL:** `/api/v1/wsd/wish-list/{customer_id}`
- **Method:** `GET`
- **Description:** Retrieve wish list with customer id.
- **Success Response:**
    - **Code:** `200 OK`
    - **Content:**
      ```json
      {
        "id": 3,
        "items": [
          {
            "itemId": 1,
            "itemName": "Item Name 1",
            "itemDescription": "Description for item 1"
          },
          {
            "itemId": 2,
            "itemName": "Item Name 2",
            "itemDescription": "Description for item 2"
          }
        ]
      }
      ```
- **Error Response:**
    - **Code:** `404 Not Found`
    - **Content:**
      ```json
      {
         "status": 404,
         "message": "Customer with 30 does not exist",
         "timestamp": "2024-05-16T07:33:09.591095919"
      }
      ```

### Sale Analytics Endpoints

#### Get Total Sale Amount Today

- **URL:** `/api/v1/wsd/sale-analytics/total-sale-amount-today`
- **Method:** `GET`
- **Description:** Retrieve the total sale amount for today.
- **Success Response:**
    - **Code:** `200 OK`
    - **Content:**
      ```json
      {
        "totalSaleAmount": 12345.67
      }
      ```
- **Error Response:**
    - **Code:** `500 Internal Server Error`
    - **Content:**
      ```json
      {
        "status": 500,
        "message": "Unable to retrieve total sale amount",
        "timestamp": "2024-05-16T07:33:09.591095919"
      }
      ```

#### Get Top Selling Items (All Time)

- **URL:** `/api/v1/wsd/sale-analytics/top-selling-items/all-time`
- **Method:** `GET`
- **Description:** Retrieve the top-selling items of all time.
- **Success Response:**
    - **Code:** `200 OK`
    - **Content:**
      ```json
      {
        "topSellingItems": [
          {
            "itemId": 1,
            "itemName": "Top Item 1",
            "quantitySold": 1000
          },
          {
            "itemId": 2,
            "itemName": "Top Item 2",
            "quantitySold": 950
          }
        ]
      }
      ```
- **Error Response:**
    - **Code:** `500 Internal Server Error`
    - **Content:**
      ```json
      {
        "status": 500,
        "message": "Unable to retrieve",
        "timestamp": "2024-05-16T07:33:09.591095919"
      }
      ```

#### Get Top Selling Items (Last Month)

- **URL:** `/api/v1/wsd/sale-analytics/top-selling-items/last-month`
- **Method:** `GET`
- **Description:** Retrieve the top-selling items of the last month.
- **Success Response:**
    - **Code:** `200 OK`
    - **Content:**
      ```json
      {
        "topSellingItems": [
          {
            "itemId": 1,
            "itemName": "Top Item 1",
            "quantitySold": 150
          },
          {
            "itemId": 2,
            "itemName": "Top Item 2",
            "quantitySold": 120
          }
        ]
      }
      ```
- **Error Response:**
    - **Code:** `500 Internal Server Error`
    - **Content:**
      ```json
      {
        "status": 500,
        "message": "Unable to retrieve",
        "timestamp": "2024-05-16T07:33:09.591095919"
      }
      ```

#### Get Max Sale Day

- **URL:** `/api/v1/wsd/sale-analytics/max-sale-day`
- **Method:** `POST`
- **Description:** Retrieve the day with the maximum sales within a given date range.
- **Request Body:**
    - **Content:**
      ```json
      {
        "startDate": "2024-04-01",
        "endDate": "2024-04-30"
      }
      ```
- **Success Response:**
    - **Code:** `200 OK`
    - **Content:**
      ```json
      {
        "maxSaleDay": "2024-04-15",
        "totalSales": 5678.90
      }
      ```
- **Error Response:**
    - **Code:** `400 Bad Request`
    - **Content:**
      ```json
      {
        "status": 400,
        "message": "Bad Request",
        "timestamp": "2024-05-16T07:33:09.591095919"
      }
      ```
    - **Code:** `500 Internal Server Error`
    - **Content:**
      ```json
      {
        "status": 500,
        "message": "Internal Server Error",
        "timestamp": "2024-05-16T07:33:09.591095919"
      }
      ```

## Error Codes

| Code | Description              |
|------|--------------------------|
| 200  | OK                       |
| 201  | Created                  |
| 400  | Bad Request              |
| 401  | Unauthorized             |
| 404  | Not Found                |
| 500  | Internal Server Error    |

