export class Priviledges {

    public static userPriviledges:Array<any>=[
        // 0th index
        {
            re:[
                {
                    label:'add new enquiry', link:'add_enquiry'
                },
                {
                    label:'view enquiries', link:'view_enquiry'
                },
                {
                    label:'view loan applications', link:'view_loans'
                }
            ],
            oe:[
                {
                    label:'add new enquiry', link:'add_enquiry'
                },
                {
                    label:'view enquiries', link:'view_enquiry'
                },
                {
                    label:'view loans', link:'view_loans'
                }
            ],
            cm:[
                {
                    label:'view loan apps', link:'view_loans'
                }
            ]
        }
        
    ]
}
